package e.isido.memo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.*;

public class MainActivity extends AppCompatActivity {
//
//    // Used to load the 'native-lib' library on application startup.
//    static {
//        System.loadLibrary("native-lib");
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        // Example of a call to a native method
//      //  TextView tv = (TextView) findViewById(R.id.sample_text);
//      //  tv.setText(stringFromJNI());
//    }
//
//    /**
//     * A native method that is implemented by the 'native-lib' native library,
//     * which is packaged with this application.
//     */
//    public native String stringFromJNI();
//    /* simple test commit*/
    EditText m_MemoEdit = null;
    TextFileManager m_TextFileManager = new TextFileManager(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        m_MemoEdit = (EditText) findViewById(R.id.memo_edit);

    }
    public void onClick(View v){
        switch(v.getId()){
            //load text
            case R.id.load_btn: {
                String memoData = m_TextFileManager.load();
                m_MemoEdit.setText(memoData);

                Toast.makeText(this, "불러오기 완료", LENGTH_LONG).show();
                break;
            }
            //save text
            case R.id.save_btn: {
                String memoData = m_MemoEdit.getText().toString();
                m_TextFileManager.save(memoData);
                m_MemoEdit.setText("");
                Toast.makeText(this, "저장 완료", LENGTH_LONG).show();
                break;
            }

            //delete text
            case R.id.delete_btn: {
                m_TextFileManager.delete();
                m_MemoEdit.setText("");
                Toast.makeText(this, "삭제 완료", LENGTH_LONG).show();
            }
        }
    }

}
