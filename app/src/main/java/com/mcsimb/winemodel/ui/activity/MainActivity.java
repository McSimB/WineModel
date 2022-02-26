package com.mcsimb.winemodel.ui.activity;

import static com.mcsimb.winemodel.model.Production.BOTTLING_LOSS;
import static com.mcsimb.winemodel.model.Production.FILTERING_LOSS;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import com.mcsimb.winemodel.R;
import com.mcsimb.winemodel.common.activity.BaseActivity;
import com.mcsimb.winemodel.model.Blend;
import com.mcsimb.winemodel.model.Part;
import com.mcsimb.winemodel.model.Production;
import com.mcsimb.winemodel.model.Sort;
import com.mcsimb.winemodel.model.Volume;

import java.util.Date;

public class MainActivity extends BaseActivity {

	private TextView text;
	private EditText edit1;
	private EditText edit2;
	private Date date;
	private Volume vol05;
	private Sort sort;
	private Blend blend;
	private int c1;
	private int c2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		text = findViewById(R.id.main_textview);
		edit1 = findViewById(R.id.main_edittext1);
		edit2 = findViewById(R.id.main_edittext2);

		edit2.setOnEditorActionListener(new OnEditorActionListener() {
			@Override
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				if (actionId == EditorInfo.IME_ACTION_DONE) {
					c1 = Integer.decode(edit1.getText().toString());
					c2 = Integer.decode(edit2.getText().toString());
					update();
				}
				return false;
			}
		});

		date = new Date();
		vol05 = new Volume(0.05f, 0.17f);
		sort = new Sort("SortName", 0);

		Production production = new Production();
		blend = new Blend(date, sort, 5190.1f);
		production.addBlend(blend);

		FILTERING_LOSS = 0.42f;
		BOTTLING_LOSS = 0.34f;

		update();
	}

	private void update() {
		Part part = new Part(date, sort, vol05, c1, c2);
		blend.addPart(part);

		StringBuilder sb = new StringBuilder();
		sb.append("Поступило:    ").append(part.getFiltering().getIncome()).append("\n");
		sb.append("В склад:      ").append(part.getDal2()).append("\n");
		sb.append("Лаборатория:  ").append(part.getBottling().getLab()).append("\n");
		sb.append("Потери 0.34%: ").append(part.getBottling().getLoss()).append(" (").append(part.getDal2() * 0.0034f).append(")\n");
		sb.append("==============================\n");
		sb.append("Остаток нач.: ").append(blend.getRest()).append("\n");
		sb.append("Потери 0.42%: ").append(part.getFiltering().getLoss()).append("\n");
		sb.append("Остатое кон.: ").append(blend.getRest() - part.getFiltering().getExpense()).append("\n");
		sb.append("==============================\n");
		float income2 = part.getFiltering().getIncome();
		float dal1 = part.getDal1();
		float a = income2 - dal1;
		float b = a / income2;
		float c = b * 100;
		sb.append("Расхождение:  ").append(c).append("\n");
		sb.append("==============================\n");
		sb.append("Осталось произвести: ").append(blend.calcRestProduction()).append("\n");
		sb.append("Потери:              ").append(blend.calcRestLosses()).append("\n");

		text.setText(sb.toString());
	}

}
