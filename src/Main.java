public class Main {
    public static void main(String[] args) {

        String plaintText = "WEAREDISCOVEREDFLEEATONCE";
        int key = 3;

        System.out.print(encryption(plaintText,key)+" ");

        String en = encryption(plaintText,key);

        System.out.println(decryption(en,key));
    }
    static String encryption(String text, int key) {
        String encryptedText = "";
        boolean check = false;
        int  j = 0;
        int row = key;
        int col = text.length();
        char [][] a = new char[row][col];

        for(int i = 0; i<  col; i++){
            if(j == 0 || j == key - 1)
                check =!check;

            a[j][i] = text.charAt(i);
            if(check)
                j++;
            else
                j--;

        }
        for(int i = 0; i< row; i++){
            for(int k = 0; k< col; k++){
                if (a[i][k] != 0)
                    encryptedText += a[i][k];
            }
        }

        return encryptedText;
    }

    static String decryption(String text, int key){
        String decrypted = "";
        boolean check = false;
        int  j = 0;
        int row = key;
        int col = text.length();
        char [][] a = new char[row][col];


        for(int i = 0; i<  col; i++){
            if(j == 0 || j == key - 1)
                check =!check;

            a[j][i] = '+';
            if(check)
                j++;
            else
                j--;
        }

        int index = 0;
        check = false;
        for (int i =0; i<row;  i++) {
            for (int k = 0; k < col; k++) {
                if (a[i][k] == '+' && index < col) {
                    a[i][k] = text.charAt(index++);
                }
            }
        }

        j =0;
        for(int i = 0; i<  col; i++){
            if(j == 0 || j == key - 1)
                check =!check;

            decrypted += a[j][i];
            if(check)
                j++;
            else
                j--;
        }
        return decrypted;


    }
}
