public class BasicMethods {
    public static void main(String[] args) {
        BasicMethods programa = new BasicMethods();
        programa.inicio();
    }

    public void inicio(){
        System.out.println("Empezando mi programa");
        printResult();
        String cadena = getResult();
        System.out.println(cadena);
        int grade = 10;
        int gradeMin = 30;
        System.out.println(getResult(grade, gradeMin));
        System.out.println("Terminando mi programa");
    }

    public void printResult(){
        System.out.println("printResult");
        System.out.println("Otras instrucciones");
    }

    public String getResult(){
        return "getResult";
    }

    /**
     * Determina el resultado de un estudiante en función de su nota
     * y la nota mínima requerida para aprobar.
     *
     * Si la nota es mayor que la nota mínima requerida,
     * el método devuelve "PASS". En caso contrario,
     * devuelve "NO PASS"
     *
     * @param grade la nota obtenida por el estudiante
     * @param gradeMin la nota mínima necesaria para aprobar
     * @return "PASS" si grade es mayor que gradeMin;
     *         en caso contrario, "NO PASS"
     */
    public String getResult(int grade, int gradeMin){
        String result;
        if (grade>gradeMin){
            result= "PASS";
        }else{
            result = "NO PASS";
        }
        return result;
    }
}
