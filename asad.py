import csv
from datetime import datetime

# Load CSV files
data = {}

for filename in ['Tmin-Hist.csv',]:
    with open(filename, 'r') as csv_file:
        reader = csv.reader(csv_file)
        next(reader)  # Skip header row
        for row in reader:
            date = datetime.strptime(row[0], '%m/%d/%Y').date()
            year = date.year
            observed = float(row[1]) if row[1] else None
            raw = float(row[2]) if row[2] else None
            ls = float(row[3]) if row[3] else None

            if year not in data:
                data[year] = {'observed': [], 'raw': [], 'ls': []}

            data[year]['observed'].append(observed)
            data[year]['raw'].append(raw)
            data[year]['ls'].append(ls)

# Calculate yearly averages and write to a new CSV file
with open('yearly_averagesTmin-Hist.csv', 'w', newline='') as csv_file:
    writer = csv.writer(csv_file)
    writer.writerow(['Year', 'Yearly Average (Observed)', 'Yearly Average (Raw)', 'Yearly Average (LS)'])

    for year, values in data.items():
        observed_values = values['observed']
        raw_values = values['raw']
        ls_values = values['ls']

        non_missing_observed = [value for value in observed_values if value is not None]
        non_missing_raw = [value for value in raw_values if value is not None]
        non_missing_ls = [value for value in ls_values if value is not None]

        if non_missing_observed:
            yearly_average_observed = sum(non_missing_observed) / len(non_missing_observed)
        else:
            yearly_average_observed = 0

        if non_missing_raw:
            yearly_average_raw = sum(non_missing_raw) / len(non_missing_raw)
        else:
            yearly_average_raw = 0

        if non_missing_ls:
            yearly_average_ls = sum(non_missing_ls) / len(non_missing_ls)
        else:
            yearly_average_ls = 0

        writer.writerow([year, yearly_average_observed, yearly_average_raw, yearly_average_ls])