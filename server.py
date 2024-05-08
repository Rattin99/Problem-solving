import whisperx
import gc


device = "cpu"
batch_size = 4
compute_type = "float16"


audio_file = r"C:\Users\User\Documents\Problem-solving\recording.webm"

audio = whisperx.load_audio(audio_file)

model = whisperx.load_model("large-v2", device, compute_type=compute_type)

result = model.transcribe(audio, batch_size=batch_size)
print(result["segments"])

