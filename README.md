# Hospital-API
# Basic design of an Hospital-API for covid-19 doctors and patients. 
# There can be 2 types of Users
1. Doctors
2. Patients

# Doctors can log in. Each time a patient visits, the doctor will follow 2 steps

1. Register the patient in the app (using phone number, if the patient already exists, just returns the patient info in the API)
2. After the checkup, create a Report Patient Report will have the following fields

1> Created by doctor 
2> Status (With enums as following):
-> Can be either of: [Negative, Travelled-Quarantine, Symptoms-Quarantine, Positive-Admit]
-> Date

# API routes:
-> POST: /doctors/register - Register a new doctor by providing a username
and password.
-> POST: /doctors/login - Authenticate the doctor and return a JWT (JSON Web
Token) to be used for subsequent requests.
-> POST: /patients/register - Register a new patient by providing the necessary
details (e.g., phone number).
-> POST: /patients/:id/create_report - Create a patient report for a specific
patient ID.
-> GET: /patients/:id/all_reports - Retrieve all the reports of a patient, ordered
from oldest to latest.
-> GET: /reports/:status - Retrieve all the reports of all patients filtered by a
specific status.

So, This is only the API's there is no frontend part in it.
