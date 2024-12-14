import java.util.Scanner;

class WrongAgeException extends Exception {
    int ag;
    public WrongAgeException(String message, int ag) {
        super(message);
        this.ag = ag;
    }
    
    @Override
    public String toString() {
        return "Invalid age: " + ag + "\n" + getMessage();
    }
}

class Father {
    int fage;
    
    boolean getfdetails() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter the age of the father:");
            this.fage = sc.nextInt();
            if (this.fage < 21) {
                throw new WrongAgeException("Enter a valid age! Minimum age of father must be 21.", this.fage);
            } else {
                System.out.println("Age of the father: " + this.fage);
                return true;
            }
        } catch (WrongAgeException e) {
            System.out.println(e);
            return false;
        }
    }
}

class Son extends Father {
    int sage;
    
    void getsdetails() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter the age of the son:");
            this.sage = sc.nextInt();
            if (super.fage < this.sage) {
                throw new WrongAgeException("Enter a valid age! Son's age cannot be greater than father's age.", this.sage);
            } else if (super.fage - this.sage < 21) {
                throw new WrongAgeException("Enter a valid age! Age difference between father and son must be at least 21 years.", this.sage);
            } else {
                System.out.println("Age of the son: " + this.sage);
            }
        } catch (WrongAgeException e) {
            System.out.println(e);
        }
    }
}

class Main4 {
    public static void main(String args[]) {
        Son s = new Son();
	System.out.println("*********************************************\nName: B Prabhanjan \n USN: 1BM23CS060 \n *********************************************");
        if (s.getfdetails()) {
            s.getsdetails();
        } else {
            System.out.println("Father's details are invalid, so you cannot enter son's details.");
        }
    }
}
