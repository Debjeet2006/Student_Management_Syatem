public class AutoSaveThread extends Thread {

    private StudentManager manager;

    public AutoSaveThread(StudentManager manager) {
        this.manager = manager;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5000); // every 5 seconds

                FileHandler.saveToFile(manager.getStudents());
                System.out.println("[AutoSave] Data saved automatically...");

            } catch (InterruptedException e) {
                System.out.println("AutoSave stopped.");
                break;
            }
        }
    }
}