package com.pideruben.guineaproject.application.fragments;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.graphics.Color;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.StrictMode;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.pideruben.guineaproject.R;
import com.pideruben.guineaproject.persistence.AppDatabase;
import com.pideruben.guineaproject.persistence.EntityBiglietto;
import com.pideruben.guineaproject.values.Prezzi;

import org.w3c.dom.Text;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class FragmentRiassunto extends Fragment {

    public FragmentRiassunto() {

    }

    public static FragmentRiassunto newInstance(String param1, String param2) {
        FragmentRiassunto fragment = new FragmentRiassunto();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }
    String Adulti;
    String Bambini;
    String Studenti;
    String Ammalati;
    String SmallLuggage;
    String MediumLuggage;
    String BigLuggage;
    String nCorsa;
    String TotaleCorsa;
    int TotaleDeposito;

    public static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");

    @SuppressLint("NewApi")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_riassunto, container, false);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Date date = new Date();
        DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(getContext());
        String dataOggi = dateFormat.format(date);

        TableLayout tl = (TableLayout) view.findViewById(R.id.tableRiassuntivoCorse);
        AppDatabase db = AppDatabase.getDatabase(getContext());
        List<EntityBiglietto> dbBiglietti = db.daoBiglietto().getAllBiglietti();

        List<Integer> numAdultiperCorsa;
        List<Integer> numBambiniCorsa;
        List<Integer> numStudentiCorsa;
        List<Integer> numInvalidiCorsa;
        List<Integer> numSmallLugageCorsa;
        List<Integer> numMediumLuggageCorsa;
        List<Integer> numBigLuggageCorsa;


        ArrayList<Integer> arrayTotaliAdulti = new ArrayList<Integer>(); //Contiene i totali degli audlti delle corse totali
        ArrayList<Integer> arrayTotaliBambini = new ArrayList<Integer>();
        ArrayList<Integer> arrayTotaliStudenti= new ArrayList<Integer>();
        ArrayList<Integer> arrayTotaliInvalidi= new ArrayList<Integer>();
        ArrayList<Integer> arrayTotaliSmall= new ArrayList<Integer>();
        ArrayList<Integer> arrayTotaliMedium= new ArrayList<Integer>();
        ArrayList<Integer> arrayTotaliBig= new ArrayList<Integer>();

        int totaleAdulti;
        int totaleBambini;
        int totaleStudenti;
        int totaleInvalidi;
        int totaleSmall;
        int totaleMedium;
        int totaleBig;

        //DatePicker
        TextView SelectDate = view.findViewById(R.id.select_date);
        SelectDate.setText(dataOggi);
        SelectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    Calendar c;
                    DatePickerDialog dp;
                    c = Calendar.getInstance();
                    int day = c.get(Calendar.DAY_OF_MONTH);
                    int month = c.get(Calendar.MONTH);
                    int year = c.get(Calendar.YEAR);
                    dp = new DatePickerDialog(view.getContext(), new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker datePicker, int mYear, int mMonth, int mDay ) {
                            if(mMonth+1<10){
                                SelectDate.setText(mDay + "/0" + (mMonth+1) + "/" + mYear);
                            }
                            else{
                                SelectDate.setText(mDay + "/" + (mMonth+1) + "/" + mYear);
                            }
                        }
                    }, year,month,day);
                    dp.show();
                }
            }
        });

        dataOggi = SelectDate.getText().toString();

        //Table
        if(!dbBiglietti.isEmpty()){
            //Ottengo i totali per corsa e li salvo negli array precedenti NB:size degli array coincide con il numero di corse;
            for(int corsa=1; corsa<=dbBiglietti.get(dbBiglietti.size()-1).n_corsa; corsa++) {
                numAdultiperCorsa = db.daoBiglietto().getAdultiCorsaData(corsa,dataOggi);
                numBambiniCorsa = db.daoBiglietto().getBambiniCorsaData(corsa, dataOggi);
                numStudentiCorsa = db.daoBiglietto().getStudentiCorsaData(corsa, dataOggi);
                numInvalidiCorsa = db.daoBiglietto().getInvalidiCorsaData(corsa, dataOggi);
                numSmallLugageCorsa = db.daoBiglietto().getSmallLugageCorsaData(corsa, dataOggi);
                numMediumLuggageCorsa = db.daoBiglietto().getMediumLuggageCorsaData(corsa, dataOggi);
                numBigLuggageCorsa = db.daoBiglietto().getBigLuggageCorsaData(corsa, dataOggi);
                totaleAdulti = 0;
                totaleBambini = 0;
                totaleStudenti = 0;
                totaleInvalidi = 0;
                totaleBig = 0;
                totaleMedium = 0;
                totaleSmall = 0;
                for (int i = 0; i < numAdultiperCorsa.size(); i++) {
                    totaleAdulti = totaleAdulti + numAdultiperCorsa.get(i);
                    totaleBambini = totaleBambini + numBambiniCorsa.get(i);
                    totaleStudenti = totaleStudenti + numStudentiCorsa.get(i);
                    totaleInvalidi = totaleInvalidi + numInvalidiCorsa.get(i);
                    totaleSmall = totaleSmall + numSmallLugageCorsa.get(i);
                    totaleMedium = totaleMedium + numMediumLuggageCorsa.get(i);
                    totaleBig = totaleBig + numBigLuggageCorsa.get(i);
                }
                arrayTotaliAdulti.add(totaleAdulti);
                arrayTotaliBambini.add(totaleBambini);
                arrayTotaliStudenti.add(totaleStudenti);
                arrayTotaliInvalidi.add(totaleInvalidi);
                arrayTotaliBig.add(totaleBig);
                arrayTotaliMedium.add(totaleMedium);
                arrayTotaliSmall.add(totaleSmall);
            }

            //Stampo su tabella
            TableRow rowTitles = new TableRow(getContext());
            TextView txTitoli = new TextView(getContext());
            txTitoli.setText("");
            txTitoli.setTextColor(Color.parseColor("#000000"));
            rowTitles.addView(txTitoli);
            int n = 1;
            for(int i=0; i<arrayTotaliAdulti.size(); i++){
                nCorsa = "Corsa " + n;
                n++;
                TextView txNCorsa = new TextView(getContext());
                txNCorsa.setText(nCorsa);
                txNCorsa.setTextColor(Color.parseColor("#000000"));
                txNCorsa.setPadding(30, 0 ,0 ,0);
                rowTitles.addView(txNCorsa);
            }
            tl.addView(rowTitles, new TableLayout.LayoutParams());

            TableRow rowAdulti = new TableRow(getContext());
            TextView txAdulti = new TextView(getContext());
            txAdulti.setText("Adulti");
            txAdulti.setTextColor(Color.parseColor("#000000"));
            txAdulti.setPadding(10, 0 ,0 ,0);
            rowAdulti.addView(txAdulti);
            for(int j = 0; j<arrayTotaliAdulti.size(); j++){
                Adulti = Integer.toString(arrayTotaliAdulti.get(j));
                TextView nAdulti = new TextView(getContext());
                nAdulti.setText(Adulti);
                nAdulti.setTextColor(Color.parseColor("#000000"));
                nAdulti.setPadding(30, 20 ,0 ,10);
                nAdulti.setGravity(Gravity.CENTER);
                rowAdulti.addView(nAdulti);
            }
            tl.addView(rowAdulti, new TableLayout.LayoutParams());

            TableRow rowBambini = new TableRow(getContext());
            TextView txBambini = new TextView(getContext());
            txBambini.setText("Bambini");
            txBambini.setTextColor(Color.parseColor("#000000"));
            txBambini.setPadding(10, 0 ,0 ,0);
            rowBambini.addView(txBambini);
            for(int corsa = 0; corsa<arrayTotaliBambini.size(); corsa++){
                Bambini = Integer.toString(arrayTotaliBambini.get(corsa));
                TextView nBambini = new TextView(getContext());
                nBambini.setText(Bambini);
                nBambini.setTextColor(Color.parseColor("#000000"));
                nBambini.setPadding(30, 10 ,0 ,10);
                nBambini.setGravity(Gravity.CENTER);
                rowBambini.addView(nBambini);
            }
            tl.addView(rowBambini, new TableLayout.LayoutParams());


            TableRow rowStudenti = new TableRow(getContext());
            TextView txStudenti = new TextView(getContext());
            txStudenti.setText("Studenti");
            txStudenti.setTextColor(Color.parseColor("#000000"));
            txStudenti.setPadding(10, 0 ,0 ,0);
            rowStudenti.addView(txStudenti);
            for(int corsa = 0; corsa<arrayTotaliStudenti.size(); corsa++){
                Studenti = Integer.toString(arrayTotaliStudenti.get(corsa));
                TextView nStudenti = new TextView(getContext());
                nStudenti.setText(Bambini);
                nStudenti.setTextColor(Color.parseColor("#000000"));
                nStudenti.setPadding(30, 10 ,0 ,10);
                nStudenti.setGravity(Gravity.CENTER);
                rowStudenti.addView(nStudenti);
            }
            tl.addView(rowStudenti, new TableLayout.LayoutParams());

            TableRow rowInvalidi = new TableRow(getContext());
            TextView txInvalidi = new TextView(getContext());
            txInvalidi.setText("Invalidi");
            txInvalidi.setTextColor(Color.parseColor("#000000"));
            txInvalidi.setPadding(10, 0 ,0 ,0);
            rowInvalidi.addView(txInvalidi);
            for(int corsa = 0; corsa<arrayTotaliInvalidi.size(); corsa++){
                Ammalati = Integer.toString(arrayTotaliInvalidi.get(corsa));
                TextView nInvalidi = new TextView(getContext());
                nInvalidi.setText(Ammalati);
                nInvalidi.setTextColor(Color.parseColor("#000000"));
                nInvalidi.setPadding(30, 10 ,0 ,10);
                nInvalidi.setGravity(Gravity.CENTER);
                rowInvalidi.addView(nInvalidi);
            }
            tl.addView(rowInvalidi, new TableLayout.LayoutParams());

            TableRow rowLuggage = new TableRow(getContext());
            TextView txLuggage = new TextView(getContext());
            txLuggage.setText("Luggage");
            txLuggage.setTextColor(Color.parseColor("#000000"));
            txLuggage.setPadding(10, 20 ,0 ,0);
            rowLuggage.addView(txLuggage);
            tl.addView(rowLuggage, new TableLayout.LayoutParams());

            TableRow rowBig = new TableRow(getContext());
            TextView txBig = new TextView(getContext());
            txBig.setText("Big");
            txBig.setTextColor(Color.parseColor("#000000"));
            txBig.setPadding(10, 0 ,0 ,0);
            rowBig.addView(txBig);
            for(int corsa = 0; corsa<arrayTotaliBig.size(); corsa++){
                BigLuggage = Integer.toString(arrayTotaliBig.get(corsa));
                TextView nBig = new TextView(getContext());
                nBig.setText(BigLuggage);
                nBig.setTextColor(Color.parseColor("#000000"));
                nBig.setPadding(30, 10 ,0 ,10);
                nBig.setGravity(Gravity.CENTER);
                rowBig.addView(nBig);
            }
            tl.addView(rowBig, new TableLayout.LayoutParams());

            TableRow rowMedium = new TableRow(getContext());
            TextView txMedium = new TextView(getContext());
            txMedium.setText("Medium");
            txMedium.setTextColor(Color.parseColor("#000000"));
            txMedium.setPadding(10, 0 ,0 ,0);
            rowMedium.addView(txMedium);
            for(int corsa = 0; corsa<arrayTotaliMedium.size(); corsa++){
                MediumLuggage = Integer.toString(arrayTotaliMedium.get(corsa));
                TextView nMedium = new TextView(getContext());
                nMedium.setText(MediumLuggage);
                nMedium.setTextColor(Color.parseColor("#000000"));
                nMedium.setPadding(30, 10 ,0 ,10);
                nMedium.setGravity(Gravity.CENTER);
                rowMedium.addView(nMedium);
            }
            tl.addView(rowMedium, new TableLayout.LayoutParams());

            TableRow rowSmall = new TableRow(getContext());
            TextView txSmall = new TextView(getContext());
            txSmall.setText("Small");
            txSmall.setTextColor(Color.parseColor("#000000"));
            txSmall.setPadding(10, 0 ,0 ,0);
            rowSmall.addView(txSmall);
            for(int corsa = 0; corsa<arrayTotaliSmall.size(); corsa++){
                SmallLuggage = Integer.toString(arrayTotaliSmall.get(corsa));
                TextView nSmall = new TextView(getContext());
                nSmall.setText(SmallLuggage);
                nSmall.setTextColor(Color.parseColor("#000000"));
                nSmall.setPadding(30, 10 ,0 ,10);
                nSmall.setGravity(Gravity.CENTER);
                rowSmall.addView(nSmall);
            }
            tl.addView(rowSmall, new TableLayout.LayoutParams());
        }

        //Totale deposito
        for(int i = 0; i<dbBiglietti.size(); i++){
            TotaleDeposito = TotaleDeposito + dbBiglietti.get(i).prezzo;
        }

        TextView totaleDeposito = view.findViewById(R.id.tx_totaleDepositare);
        totaleDeposito.setText(Integer.toString(TotaleDeposito));

        //SendJSON
        Button sendButton = view.findViewById(R.id.sendBiglietti);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> json = createJSON();

                try {
                    for(String biglietto : json)
                        SendTickets("http://172.104.132.177/api/corse", biglietto);
                }
                catch (IOException exception){
                    exception.printStackTrace();
                };

            }
        });


        return view;
    }

    ArrayList<String> createJSON(){
        ArrayList<String> json = new ArrayList<String>();
        AppDatabase db = AppDatabase.getDatabase(getContext());
        List<EntityBiglietto> biglietti = db.daoBiglietto().getAllBiglietti();
        for(EntityBiglietto biglietto : biglietti){
            String data = biglietto.data;
            /*
            String mese = data.substring(0,data.indexOf(" "));
            switch (mese){
                case "December":
                    mese = "12";
                    break;
                case "November":
                    mese = "11";
                    break;
                case "October":
                    mese = "10";
                    break;
                case "September":
                    mese = "09";
                    break;
                case "August":
                    mese = "08";
                    break;
                case "July":
                    mese = "07";
                    break;
                case "June":
                    mese = "06";
                    break;
                case "May":
                    mese = "05";
                    break;
                case "April":
                    mese = "04";
                    break;
                case "March":
                    mese = "03";
                    break;
                case "February":
                    mese = "02";
                    break;
                case "January":
                    mese = "01";
                    break;

            }
            String giorno = data.substring(data.indexOf(" "), data.indexOf(","));
            String anno = data.substring(data.lastIndexOf(" ")+1, data.length());
            String dataJSON = giorno+"/"+mese+"/"+anno;*/
            //Log.i("DATACAZZO", dataJSON);

            json.add("{\"n_adulti\" : \""+biglietto.n_adulti + "\", \"n_bambini\" : \""+biglietto.n_bambini + "\", \"n_studenti\" : \""+biglietto.n_studenti +
                    "\", \"n_ammalati\" : \""+biglietto.n_invalidi + "\", \"n_bagagli_piccoli\" : \""+biglietto.n_bagagli_piccoli + "\", \"n_bagagli_medi\" : \""+biglietto.n_bagagli_medi +
                    "\", \"n_bagagli_grandi\" : \""+biglietto.n_bagagli_grandi + "\", \"da\" : \""+biglietto.da + "\", \"a\" : \""+biglietto.a + "\", \"prezzo\" : \""+biglietto.prezzo + "\", \"data\" : \""+biglietto.data + "\"}");
            Log.i("CAZZO", json.get(0));
        }
        return json;
    }

    String SendTickets(String url, String json)throws IOException {
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

}