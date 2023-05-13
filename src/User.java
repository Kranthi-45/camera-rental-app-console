import java.util.ArrayList;

class User {
    private String username;
    private String password;
    private ArrayList<Camera> myCameras;
    private double wallet;

    public User(String username, String password, double wallet) {
        this.username = username;
        this.password = password;
        myCameras = new ArrayList<>();
        // wallet = 0;
        this.wallet = wallet;
    }
    
    public User(String username, String password, ArrayList<Camera> myCameras, double wallet) {
		super();
		this.username = username;
		this.password = password;
        myCameras = new ArrayList<>();
        wallet = 0;
	}

	public String getUsername() {
        return username;
    }
	
	public String getPassword() {
        return password;
    }
	
//    public boolean checkPassword(String password) {
//        return this.password.equals(password);
//    }

    public ArrayList<Camera> getMyCameras() {
        return myCameras;
    }

    public void addCamera(Camera camera) {
        myCameras.add(camera);
    }
    
    public void setMyCameras(ArrayList<Camera> myCameras) {
        this.myCameras = myCameras;
    }

    public void removeCamera(int id) {
        for (Camera camera : myCameras) {
            if (camera.getId() == id) {
                myCameras.remove(camera);
                System.out.println("Camera with ID " + id + " removed from your list.");
                return;
            }
        }
        System.out.println("Camera with ID " + id + " not found in your list.");
    }

    public void viewMyCameras() {
        if (myCameras.isEmpty()) {
            System.out.println("You have no cameras in your list.");
            return;
        }
        System.out.println(String.format("%-10s%-15s%-15s%-20s%-15s", "CAMERA ID", "BRAND", "MODEL", "PRICE (PER DAY)", "STATUS"));
        for (Camera camera : myCameras) {
            System.out.println(camera);
        }
    }
    
    public double getWallet() {
        return wallet;
    }

    public void addMoneyToWallet(double amount) {
        wallet += amount;
    }

    public void deductMoneyFromWallet(double amount) {
        if (wallet < amount) {
            System.out.println("Insufficient balance in your wallet.");
            return;
        }
        wallet -= amount;
        System.out.println("Amount of INR " + amount + " deducted from your wallet.");
    }
    
    public void rentCamera(Camera camera, int days) {
        if (wallet < camera.getPrice() * days) {
            System.out.println("Insufficient balance in your wallet.");
            return;
        }
        camera.setStatus("RENTED");
        double rentAmount = camera.getPrice() * days;
        wallet -= rentAmount;
        System.out.println("Amount of INR " + rentAmount + " deducted from your wallet for renting camera with ID " + camera.getId() + ".");
    }
}