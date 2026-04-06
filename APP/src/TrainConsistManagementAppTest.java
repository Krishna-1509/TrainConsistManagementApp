// ================= UC11 TEST CASES =================

@Test
void testRegex_ValidTrainID() {
    assertTrue(TrainConsistManagementApp.isValidTrainID("TRN-1234"));
}

@Test
void testRegex_InvalidTrainIDFormat() {
    assertFalse(TrainConsistManagementApp.isValidTrainID("TRAIN12"));
    assertFalse(TrainConsistManagementApp.isValidTrainID("TRN12A"));
    assertFalse(TrainConsistManagementApp.isValidTrainID("1234-TRN"));
}

@Test
void testRegex_ValidCargoCode() {
    assertTrue(TrainConsistManagementApp.isValidCargoCode("PET-AB"));
}

@Test
void testRegex_InvalidCargoCodeFormat() {
    assertFalse(TrainConsistManagementApp.isValidCargoCode("PET-ab"));
    assertFalse(TrainConsistManagementApp.isValidCargoCode("PET123"));
    assertFalse(TrainConsistManagementApp.isValidCargoCode("AB-PET"));
}

@Test
void testRegex_TrainIDDigitLengthValidation() {
    assertFalse(TrainConsistManagementApp.isValidTrainID("TRN-123"));
    assertFalse(TrainConsistManagementApp.isValidTrainID("TRN-12345"));
}

@Test
void testRegex_CargoCodeUppercaseValidation() {
    assertFalse(TrainConsistManagementApp.isValidCargoCode("PET-Ab"));
}

@Test
void testRegex_EmptyInputHandling() {
    assertFalse(TrainConsistManagementApp.isValidTrainID(""));
    assertFalse(TrainConsistManagementApp.isValidCargoCode(""));
}

@Test
void testRegex_ExactPatternMatch() {
    assertFalse(TrainConsistManagementApp.isValidTrainID("TRN-1234-EXTRA"));
    assertFalse(TrainConsistManagementApp.isValidCargoCode("PET-ABC"));
}