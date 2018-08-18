package comwidgettst.example.uiwidgettest;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private ImageView imageView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.edit_text);
        imageView = (ImageView) findViewById(R.id.image_view);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
    }

    public void myClick(View view)
    {
        /* 打印EditText内容 */
        String inputText = editText.getText().toString();
        Toast.makeText(MainActivity.this,inputText,Toast.LENGTH_SHORT).show();

        /*动态改变图片*/
        imageView.setImageResource(R.drawable.img2);

        /* 切换进度条可见性 */
//        if(progressBar.getVisibility() == View.VISIBLE) {
//            progressBar.setVisibility(View.GONE);
//        } else {
//            progressBar.setVisibility(View.VISIBLE);
//        }

        /* 水平进度条 */
        int progress = progressBar.getProgress();
        progress += 10;
        progressBar.setProgress(progress);

        /* AlertDialog */
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("This is AlertDialog");
        dialog.setMessage("Important Information.");
        dialog.setCancelable(false);
        dialog.setPositiveButton("OK", new DialogInterface.
            OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            }
        );
        dialog.setNegativeButton("Cancel", new DialogInterface.
                        OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                }
        );
        dialog.show();

    }

}
