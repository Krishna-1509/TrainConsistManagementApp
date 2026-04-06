// UC12 TESTS

@Test
void testSafety_AllBogiesValid() {
    List<TrainConsistManagementApp.GoodsBogie> list = Arrays.asList(
            new TrainConsistManagementApp.GoodsBogie("Cylindrical", "Petroleum"),
            new TrainConsistManagementApp.GoodsBogie("Open", "Coal")
    );

    assertTrue(TrainConsistManagementApp.checkSafetyCompliance(list));
}

@Test
void testSafety_CylindricalWithInvalidCargo() {
    List<TrainConsistManagementApp.GoodsBogie> list = Arrays.asList(
            new TrainConsistManagementApp.GoodsBogie("Cylindrical", "Coal")
    );

    assertFalse(TrainConsistManagementApp.checkSafetyCompliance(list));
}

@Test
void testSafety_NonCylindricalBogiesAllowed() {
    List<TrainConsistManagementApp.GoodsBogie> list = Arrays.asList(
            new TrainConsistManagementApp.GoodsBogie("Open", "Coal"),
            new TrainConsistManagementApp.GoodsBogie("Box", "Grain")
    );

    assertTrue(TrainConsistManagementApp.checkSafetyCompliance(list));
}

@Test
void testSafety_MixedBogiesWithViolation() {
    List<TrainConsistManagementApp.GoodsBogie> list = Arrays.asList(
            new TrainConsistManagementApp.GoodsBogie("Cylindrical", "Petroleum"),
            new TrainConsistManagementApp.GoodsBogie("Cylindrical", "Coal")
    );

    assertFalse(TrainConsistManagementApp.checkSafetyCompliance(list));
}

@Test
void testSafety_EmptyBogieList() {
    List<TrainConsistManagementApp.GoodsBogie> list = new ArrayList<>();

    assertTrue(TrainConsistManagementApp.checkSafetyCompliance(list));
}