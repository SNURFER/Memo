package e.isido.memo;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TextFileManager {
    private static final String FILE_NAME="Memo.txt";
    //메모 내용을 저장할 임시 파일
    Context mContext = null;
    public TextFileManager(Context context) {
        mContext = context;
    }
    //파일에 메모 저장하는 로직
    public void save(String strData){
        if(strData == null || strData.equals("")){
            return;
        }

        FileOutputStream fosMemo = null;

        try {
            //파일에 데이터를 쓰기 위해 output 스트림 생성
            fosMemo = mContext.openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
            //파일에 메모 적기

            fosMemo.write(strData.getBytes());
            fosMemo.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public String load() {
        try {
            //파일에서 데이터를 읽기 위해 input 스트림 구현
            FileInputStream fisMemo = mContext.openFileInput(FILE_NAME);

            //데이터를 읽어 온 뒤, String 타입 객체로 반환
            byte[] memoData = new byte[fisMemo.available()];
            while (fisMemo.read(memoData)!= -1){}

            return new String(memoData);
        } catch (IOException e){}

        return "";
    }

    public void delete() {
        mContext.deleteFile(FILE_NAME);
    }

}