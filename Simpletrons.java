
public class Simpletrons {
    private int[] memory = new int[1000]; // Ampliado a 1000 posiciones
    private int register;
    
    // Definición de códigos de operación
    public static final int READ = 10;
    public static final int WRITE = 11;
    public static final int LOAD = 20;
    public static final int STORE = 21;
    public static final int ADD = 30;
    public static final int SUBTRACT = 31;
    public static final int MULTIPLY = 32;
    public static final int DIVIDE = 33;
    public static final int MOD = 50;   //Operación para módulo
    public static final int EXP = 51;   //Operación para exponenciación
    public static final int HALT = 43;

    public Simpletrons() {
        this.register = 0;
    }

    public void execute(int instruction) {
        int operationCode = instruction / 100;
        int operand = instruction % 100;

        switch (operationCode) {
            case ADD:
                register += memory[operand];
                break;
            case SUBTRACT:
                register -= memory[operand];
                break;
            case MULTIPLY:
                register *= memory[operand];
                break;
            case DIVIDE:
                register /= memory[operand];
                break;
            case MOD:  // Módulo
                register = memory[operand] % register;
                break;
            case EXP:  // Exponenciación
                register = (int) Math.pow(register, memory[operand]);
                break;
            case HALT:
                System.out.println("El programa ha terminado.");
                break;
            default:
                System.out.printf("Instrucción no reconocida: %04X
", instruction);  // Hexadecimal
        }
    }

    //Representar en hexadecimal
    public void printMemoryHex() {
        for (int i = 0; i < memory.length; i++) {
            System.out.printf("%04X ", memory[i]);
            if ((i + 1) % 10 == 0) System.out.println(); // Salto de línea cada 10 instrucciones
        }
    }
}
