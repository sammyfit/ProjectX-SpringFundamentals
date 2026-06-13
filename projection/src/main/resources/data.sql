-- Seed data re-inserted on every startup.
-- Safe because ddl-auto=create drops & recreates the patient table each run,
-- so there are never duplicate rows.
-- created_at is set explicitly here because @CreationTimestamp only fires on
-- JPA persists, not on raw SQL inserts.

INSERT INTO patient (name, birth_date, email, gender, blood_group, created_at) VALUES
('Aarav Sharma',    DATE '1995-03-15', 'aarav.sharma@example.com',    'Male',   'O_POSITIVE',  CURRENT_TIMESTAMP),
('Priya Patel',     DATE '1992-07-21', 'priya.patel@example.com',     'Female', 'A_POSITIVE',  CURRENT_TIMESTAMP),
('Ronnie Mehta',    DATE '1988-11-05', 'rohan.mehta@example.com',     'Male',   'B_POSITIVE',  CURRENT_TIMESTAMP),
('Sneha Iyer',      DATE '1997-01-12', 'sneha.iyer@example.com',      'Female', 'AB_POSITIVE', CURRENT_TIMESTAMP),
('Vikram Singh',    DATE '1990-09-18', 'vikram.singh@example.com',    'Male',   'O_NEGATIVE',  CURRENT_TIMESTAMP),
('Ananya Gupta',    DATE '1994-04-26', 'ananya.gupta@example.com',    'Female', 'A_NEGATIVE',  CURRENT_TIMESTAMP),
('Karan Verma',     DATE '1989-12-30', 'karan.verma@example.com',     'Male',   'B_NEGATIVE',  CURRENT_TIMESTAMP),
('Neha Kapoor',     DATE '1996-06-14', 'neha.kapoor@example.com',     'Female', 'AB_NEGATIVE', CURRENT_TIMESTAMP),
('Rahul Nair',      DATE '1993-08-09', 'rahul.nair@example.com',      'Male',   'O_POSITIVE',  CURRENT_TIMESTAMP),
('Pooja Desai',     DATE '1998-02-22', 'pooja.desai@example.com',     'Female', 'A_POSITIVE',  CURRENT_TIMESTAMP),
('Arjun Bose',      DATE '1991-05-11', 'arjun.bose@example.com',      'Male',   'B_POSITIVE',  CURRENT_TIMESTAMP),
('Meera Joshi',     DATE '1995-10-03', 'meera.joshi@example.com',     'Female', 'AB_POSITIVE', CURRENT_TIMESTAMP),
('Siddharth Roy',   DATE '1987-07-27', 'siddharth.roy@example.com',   'Male',   'O_NEGATIVE',  CURRENT_TIMESTAMP),
('Kavya Menon',     DATE '1999-01-17', 'kavya.menon@example.com',     'Female', 'A_NEGATIVE',  CURRENT_TIMESTAMP),
('Aditya Kulkarni', DATE '1992-12-08', 'aditya.kulkarni@example.com', 'Male',   'B_NEGATIVE',  CURRENT_TIMESTAMP);

INSERT INTO doctor (name, specialization, email) VALUES
('Dr. Salman Khan', 'Cardiology', 'bhaijaan.thedoctor@gmail.com'),
('Dr. Akshay Kumar', 'Physician', 'akbaba.cured@gamil.com'),
('Dr. Ranveer Singh', 'surgeon', 'indiakabestsurgeon@gmail.com');
