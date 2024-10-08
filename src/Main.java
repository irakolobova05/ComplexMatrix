public class Main {
    public static void main(String[] args) {
        matrix mat1=new matrix(3,3);
        mat1.setMatr(0, 0, new complex(1,-1));
        mat1.setMatr(0, 1, new complex(0,3));
        mat1.setMatr(0, 2, new complex(-2,-2));
        mat1.setMatr(1, 0, new complex(0,0));
        mat1.setMatr(1, 1, new complex(2,0));
        mat1.setMatr(1, 2, new complex(0,1));
        mat1.setMatr(2, 0, new complex(-4,2));
        mat1.setMatr(2, 1, new complex(0,-1));
        mat1.setMatr(2, 2, new complex(1,0));
        matrix mat2=new matrix(3,3);
        mat2.setMatr(0, 0, new complex(0,2));
        mat2.setMatr(0, 1, new complex(1,3));
        mat2.setMatr(0, 2, new complex(3,-1));
        mat2.setMatr(1, 0, new complex(-2,-2));
        mat2.setMatr(1, 1, new complex(4,0));
        mat2.setMatr(1, 2, new complex(0,1));
        mat2.setMatr(2, 0, new complex(-1,-3));
        mat2.setMatr(2, 1, new complex(5,0));
        mat2.setMatr(2, 2, new complex(-3,1));

        System.out.println("Matrix 1");
        System.out.println( mat1.printInfo());
        System.out.println("Matrix 2");
        System.out.println( mat2.printInfo());
        System.out.println("Matrix1 + Matrix2 =");
        System.out.println( mat1.summarise(mat2).printInfo());
        System.out.println("Matrix1 - Matrix2 =");
        System.out.println( mat1.subtraction(mat2).printInfo());
        System.out.println("Matrix1 * Matrix2 =");
        System.out.println( mat1.multiplication(mat2).printInfo());
        System.out.println("Matrix1 transposed:");
        System.out.println( mat1.transp().printInfo());
        System.out.println("The determinant of Matrix1");
        System.out.println( mat1.det().printI());
        System.out.println("The determinant of Matrix2");
        System.out.println( mat2.det().printI());
        System.out.println("The inverse Matrix1");
        System.out.println( mat1.reverse().printInfo());
        System.out.println("Matrix1 / Matrix2 =");
        System.out.println( mat1.divv(mat2).printInfo());

    }
}