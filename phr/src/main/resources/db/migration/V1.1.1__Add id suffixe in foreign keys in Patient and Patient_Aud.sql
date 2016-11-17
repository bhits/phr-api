ALTER TABLE `patient` CHANGE COLUMN `address_use_code` `address_use_code_id` bigint(20);
ALTER TABLE `patient` CHANGE COLUMN `country_code` `country_code_id` bigint(20);
ALTER TABLE `patient` CHANGE COLUMN `state_code`  `state_code_id` bigint(20);
ALTER TABLE `patient` CHANGE COLUMN `administrative_gender_code`  `administrative_gender_code_id` bigint(20);
ALTER TABLE `patient` CHANGE COLUMN `telecom_use_code`  `telecom_use_code_id` bigint(20);

ALTER TABLE `patient_aud` CHANGE COLUMN `address_use_code`  `address_use_code_id` bigint(20);
ALTER TABLE `patient_aud` CHANGE COLUMN `country_code`  `country_code_id` bigint(20);
ALTER TABLE `patient_aud` CHANGE COLUMN `state_code`  `state_code_id` bigint(20);
ALTER TABLE `patient_aud` CHANGE COLUMN `administrative_gender_code`  `administrative_gender_code_id` bigint(20);
ALTER TABLE `patient_aud` CHANGE COLUMN `telecom_use_code`  `telecom_use_code_id`  bigint(20);