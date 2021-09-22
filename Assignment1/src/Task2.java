public class Task2 {
    public static void main (String[] args) {
        Room room = new Room();
        room.setData(1, "Single", 18.2f, true);
        room.displayData();
    }

    public static class Room {
        Integer roomNo;
        String roomType;
        Float roomArea;
        Boolean acMachine;

        public void setData(Integer roomNo, String roomType, Float roomArea, Boolean acMachine) {
            this.roomNo = roomNo;
            this.roomType = roomType;
            this.roomArea = roomArea;
            this.acMachine = acMachine;
        }

        public void displayData() {
            System.out.println("Room No : "+ roomNo);
            System.out.println("Room Type : "+ roomType);
            System.out.println("Room Area : "+ roomArea);
            System.out.println("AC : "+ acMachine);
        }
    }
}
