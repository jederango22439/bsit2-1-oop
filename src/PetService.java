public class PetService {
    public double calculateFee() {
        return 50.0;
    }

    public double calculateFee(boolean withVaccination) {
        if (withVaccination) {
            return 50.0 + 25.0;
        } else {
            return 50.0;
        }
    }

    public double calculateFee(boolean withVaccination, boolean withGrooming) {
        double fee = 50.0;
        if (withVaccination) fee += 25.0;
        if (withGrooming) fee += 30.0;
        return fee;
    }

    public double calculateFee(String emergency) {
        return 200.0;
    }
}