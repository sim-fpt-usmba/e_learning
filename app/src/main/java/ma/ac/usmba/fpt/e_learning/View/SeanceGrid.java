package ma.ac.usmba.fpt.e_learning.View;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.GridLayout;

import java.util.ArrayList;

import ma.ac.usmba.fpt.e_learning.Model.Seance;
import ma.ac.usmba.fpt.e_learning.R;


public class SeanceGrid extends GridLayout {
    ArrayList<Button> seanceBtnList;
    public SeanceGrid(Context context, ArrayList<Seance> seances) {
        super(context);

        this.setUseDefaultMargins(true);

        seanceBtnList = new ArrayList<>();

        this.setRowCount(seances.size()/3);
        this.setColumnCount(3);
        for (Seance m: seances) {
            Button tempBtn = new Button(context);
            tempBtn.setText(m.getTitle());
            tempBtn.setPadding(10,10,10,10);
            tempBtn.setTextColor(getResources().getColor(R.color.whitecolor));
            tempBtn.setBackgroundColor(getResources().getColor(R.color.dark_gray));
            tempBtn.setHeight((int)(tempBtn.getHeight() * 1.2));
            tempBtn.setWidth(tempBtn.getWidth());
            this.addView(tempBtn);
        }
    }

    public SeanceGrid(Context context) {
        super(context);
    }

    public SeanceGrid(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SeanceGrid(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private int dpToPx(int dp,Context context) {
        return (int)(dp * context.getResources().getDisplayMetrics().density);
    }
}
