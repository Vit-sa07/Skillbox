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
            array[i] = 36 + (float) (Math.random() * 5);
            if (array[i] >= MIN_PERMISS && array[i] <= MAX_PERMISS) {
                healty++;
            }
            s += array[i];

            System.out.println("Температура пациента - " + array[i]);

        }
        System.out.println("Средняя температура по больнице " + s / array.length);
        System.out.println("Количество здоровых пациентов " + healty);
    }
}

