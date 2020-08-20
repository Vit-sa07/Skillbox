import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) {
        final int PATIENTS_COUNT = 30;
        final float MAX_TEMP = 32.0f;
        final float MIN_TEMP = 40.0f;
        final float MAX_PERMISS = 36.9f;
        final float MIN_PERMISS= 36.2f;


        float[] array = new float [PATIENTS_COUNT];
        float s = 0; 
        int healty = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = 36 + (float) (Math.random() * 5) ;
            String formattedDouble = new DecimalFormat("#0.00").format(array[i]);
            if (array[i] >= MIN_PERMISS && array[i] <= MAX_PERMISS) {
                healty++;
            }
            s += array[i];

            System.out.println("Температура пациента - " + formattedDouble);
        }
        float a = s / array.length;
        float roundOff = Math.round(a * 100.0f) / 100.0f;
        System.out.println("Средняя температура по больнице " + roundOff);
        System.out.println("Количество здоровых пациентов " + healty);
    }
}

