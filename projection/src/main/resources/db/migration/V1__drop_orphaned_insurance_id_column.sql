-- The @JoinColumn was renamed from the default "insurance_id" to
-- "patient_insurance" in the Patient entity. ddl-auto=update added the new
-- column but left the old one behind as an orphan. This migration cleans it up.

-- Safety: if any FK values were stored in the old column, carry them over
-- to the new column before dropping (only fills rows not already set).
UPDATE patient
SET patient_insurance = insurance_id
WHERE patient_insurance IS NULL
  AND insurance_id IS NOT NULL;

-- Remove the orphaned column. All other patient data is untouched.
ALTER TABLE patient
    DROP COLUMN insurance_id;
