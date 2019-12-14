package dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import ui.R;

public class CustomDialog extends Dialog implements View.OnClickListener {
    private LeaveMyDialogListener listener;

    public CustomDialog(Context context,int theme,LeaveMyDialogListener listener){
        super(context,theme);
        this.listener=listener;
    }
    @Override
    public void onClick(View v) {
        listener.onClick(v);
    }
    public interface LeaveMyDialogListener{
        void onClick(View view);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.customdialog);
        TextView custom_text = findViewById(R.id.custom_text);
        TextView custom_sure = findViewById(R.id.custom_sure);
        TextView custom_out = findViewById(R.id.custom_out);
        custom_text.setText("确认把该歌曲从歌单中移除？");
        custom_sure.setOnClickListener(this);
        custom_out.setOnClickListener(this);
    }
}
