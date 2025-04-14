package zz.chat.gpt;

public class Car {
    // 필드 선언
    private String brand;   // 브랜드
    private double fuel;    // 남은 연료량 (단위: L)

    // 생성자: 초기 브랜드와 연료량 설정
    public Car(String brand, double fuel) {
        this.brand = brand;

        // 연료량 유효성 검사: 음수일 경우 0으로 초기화
        if (fuel < 0) {
            System.out.println("연료량은 음수가 될 수 없습니다. 연료를 0으로 설정합니다.");
            this.fuel = 0;
        } else {
            this.fuel = fuel;
        }
    }

    // 메서드: 주행
    public void drive(double distance) {
        double fuelNeeded = distance * 0.1; // 1km당 0.1L 연료 소모
        if (fuelNeeded > fuel) {
            System.out.println("연료가 부족하여 주행할 수 없습니다!");
            System.out.println("필요한 연료: " + fuelNeeded + "L, 현재 연료: " + fuel + "L");
        } else {
            fuel -= fuelNeeded; // 연료 감소
            System.out.println(distance + "km 주행 완료! 소모된 연료: " + fuelNeeded + "L");
        }
    }

    // 메서드: 연료 잔량 출력
    public void displayFuel() {
        System.out.println("현재 " + brand + " 차량의 남은 연료: " + fuel + "L");
    }
}