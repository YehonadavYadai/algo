public class NumberGame_Optimal {
    int arr[];//
    int size;

    public NumberGame_Optimal(int Arr[]) { // בנאי
        size = Arr.length;
        arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Arr[i];
        }
    }

    public int[][] getMartix() { // יצירת מטריצה ומילויה ע"פ הנוסחא שנלמדה בשיעור
        int mat[][] = new int[size][size];
        for (int i = 0; i < size; i++) {
            mat[i][i] = arr[i];
        }
        for (int j = 1; j < size; j++) { // מילוי המשולש העליון של המטריצה
            for (int i = 0; i < size - j; i++) {
                int x = arr[i] - mat[i + 1][i + j];
                int y = arr[i + j] - mat[i][i + j - 1];
                mat[i][i + j] = Math.max(x, y);
            }
        }
        return mat;
    }

    public int playYourBest() { // פונקציה לחישוב המשחק האופטימאלי
        int mat[][] = getMartix();
        int i = 0;
        int j = size - 1;
        int first = 0, second = 0; // האינדקסים של לקיחת הקלפים
        int sumFirst = 0, sumSecond = 0;
        for (int t = 0; t < (size / 2); t++) {
// השחקן הראשון לוקח קלף
            if (arr[i] - mat[i + 1][j] > arr[j] - mat[i][j - 1]) {
                sumFirst = sumFirst + arr[i];
                first = i; // הקלף הראשון עדיף לכן הוא נלקח -
                i++; // המערך "מתקצר" מראשו
            } else {
                sumFirst = sumFirst + arr[j];
                first = j; // הקלף השני עדיף לכן הוא נלקח -
                j--; // המערך "מתקצר" מסופו
            }
            if (j > 0) { // השחקן השני לוקח קלף כל עוד יש יותר מאיבר אחד במערך -
// החישוב אופטימאלי גם לשחקן השני, כמובן שהראשון עדיין ינצח
                if (arr[i] - mat[i + 1][j] > arr[j] - mat[i][j - 1]) {
                    sumSecond = sumSecond + arr[i];
                    second = i;
                    i++;
                } else {
                    sumSecond = sumSecond + arr[j];
                    second = j;
                    j--;
                }
            } else { // נשאר רק קלף אחד השחקן השני מחויב לקחת אותו -
                second = j;
                sumSecond = sumSecond + arr[j];
            }
            System.out.println("first take " + arr[first] +
                    ", and second take " + arr[second]);
        } // סוף הלולאה
        System.out.println();
        System.out.println("firstSum = " + sumFirst +
                ", secondSum = " + sumSecond);
        return sumFirst;
    }
}