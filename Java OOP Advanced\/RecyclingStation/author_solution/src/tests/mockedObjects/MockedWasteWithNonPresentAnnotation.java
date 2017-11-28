package tests.mockedObjects;


import main.wasteDisposal.Contracts.Waste;

@MockedNonPresentAnnotation
public class MockedWasteWithNonPresentAnnotation implements Waste{
    @Override
    public String getName() {
        return null;
    }

    @Override
    public double getVolumePerKg() {
        return 0;
    }

    @Override
    public double getWeight() {
        return 0;
    }
}
