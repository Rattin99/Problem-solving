import torch
from pyannote.audio import Pipeline
from transformers import pipeline, AutoModelForCausalLM

from config import ModelSettings, InferenceConfig

# Load model configurations
model_settings = ModelSettings(
    asr_model="openai/whisper-large-v3",
    diarization_model="pyannote/speaker-diarization-3.1",
    hf_token="YOUR_HUGGING_FACE_TOKEN"  # Replace with your actual token
)

inference_config = InferenceConfig(
    task="transcribe",
    batch_size=1,  # Set to 1 for diarization
    assisted=False,  # Set to True to use speculative decoding
    chunk_length_s=30,
    sampling_rate=16000,
    language="en",  # Set the language for transcription
    num_speakers=2,  # Set the expected number of speakers
)

# Set up the device (CPU or GPU)
device = torch.device("cuda" if torch.cuda.is_available() else "cpu")
torch_dtype = torch.float16 if device.type == "cuda" else torch.float32

# Load the ASR pipeline
asr_pipeline = pipeline(
    "automatic-speech-recognition",
    model=model_settings.asr_model,
    torch_dtype=torch_dtype,
    device=device
)

# Load the diarization pipeline
diarization_pipeline = Pipeline.from_pretrained(
    checkpoint_path=model_settings.diarization_model,
    use_auth_token=model_settings.hf_token,
)

# Load the assistant model for speculative decoding (optional)
assistant_model = None
if inference_config.assisted:
    assistant_model = AutoModelForCausalLM.from_pretrained(
        model_settings.assistant_model,
        torch_dtype=torch_dtype,
        low_cpu_mem_usage=True,
        use_safetensors=True
    )

# Transcribe and perform speaker diarization
def transcribe_and_diarize(audio_file):
    from diarization_utils import prepare_audio, generate_diarized_transcript

    # Preprocess the audio file
    audio_data = prepare_audio(
        audio_file,
        inference_config.chunk_length_s,
        inference_config.sampling_rate
    )

    # Perform ASR
    transcription = asr_pipeline(
        audio_data,
        batch_size=inference_config.batch_size,
        language=inference_config.language,
        task=inference_config.task,
        assistant_model=assistant_model if inference_config.assisted else None
    )["text"]

    # Perform diarization
    diarized_transcript = generate_diarized_transcript(
        diarization_pipeline,
        audio_data,
        transcription,
        num_speakers=inference_config.num_speakers
    )

    return diarized_transcript

# Example usage
audio_file_path = "recording.mp3"
diarized_transcript = transcribe_and_diarize(audio_file_path)
print(diarized_transcript)