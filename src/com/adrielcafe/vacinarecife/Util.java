package com.adrielcafe.vacinarecife;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.text.Html;

import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;

public class Util {
	public static final LatLng LAT_LNG_RECIFE = new LatLng(-8.0464492, -34.9324883);
	public static final Map<String, LatLng> LAT_LNG_RECIFE_DISTRICTS = new HashMap<String, LatLng>();
	public static final Gson GSON = new Gson();
	public static final String ABOUT_MESSAGE = "<b>Vacina Recife</b> é um software livre, seu código fonte está disponível no <a href='https://github.com/adrielcafe/VacinaRecife'>GitHub</a>."
											 + "<br><br>Desenvolvido por:<br>Adriel Café (ac@adrielcafe.com)";
	
	static {
		LAT_LNG_RECIFE_DISTRICTS.put("SANTO AMARO", new LatLng(-8.0477219, -34.8797126));
		LAT_LNG_RECIFE_DISTRICTS.put("BAIRRO DO RECIFE", new LatLng(-8.0568769, -34.8703881));
		LAT_LNG_RECIFE_DISTRICTS.put("CABANGA", new LatLng(-8.0796707, -34.8953399));
		LAT_LNG_RECIFE_DISTRICTS.put("ILHA JOANA BEZERRA", new LatLng(-8.0714918, -34.8973944));
		LAT_LNG_RECIFE_DISTRICTS.put("COELHOS", new LatLng(-8.0674616, -34.8893655));
		LAT_LNG_RECIFE_DISTRICTS.put("BOA VISTA", new LatLng(-8.0555337, -34.8888517));
		LAT_LNG_RECIFE_DISTRICTS.put("CAMPO GRANDE", new LatLng(-8.0304984, -34.8801107));
		LAT_LNG_RECIFE_DISTRICTS.put("CAMPINA DO BARRETO", new LatLng(-8.0168638, -34.8824519));
		LAT_LNG_RECIFE_DISTRICTS.put("PEIXINHOS", new LatLng(-8.0214163, -34.8788753));
		LAT_LNG_RECIFE_DISTRICTS.put("BOMBA DO HEMETERIO", new LatLng(-8.0211078, -34.9023723));
		LAT_LNG_RECIFE_DISTRICTS.put("PORTO DA MADEIRA", new LatLng(-8.007391, -34.8897042));
		LAT_LNG_RECIFE_DISTRICTS.put("AGUA FRIA", new LatLng(-8.0157985, -34.8951965));
		LAT_LNG_RECIFE_DISTRICTS.put("LINHA DO TIRO", new LatLng(-8.0088611, -34.9054541));
		LAT_LNG_RECIFE_DISTRICTS.put("DOIS UNIDOS", new LatLng(-7.9973082, -34.9111459));
		LAT_LNG_RECIFE_DISTRICTS.put("ARRUDA", new LatLng(-8.026699, -34.891111));
		LAT_LNG_RECIFE_DISTRICTS.put("ÁGUA FRIA", new LatLng(-8.0157985, -34.8951965));
		LAT_LNG_RECIFE_DISTRICTS.put("BEBERIBE", new LatLng(-8.0057117, -34.8961814));
		LAT_LNG_RECIFE_DISTRICTS.put("ESPINHEIRO", new LatLng(-8.0442081, -34.8908589));
		LAT_LNG_RECIFE_DISTRICTS.put("POCO DA PANELA", new LatLng(-8.0353859, -34.9226995));
		LAT_LNG_RECIFE_DISTRICTS.put("APIPUCOS", new LatLng(-8.0181787, -34.9355274));
		LAT_LNG_RECIFE_DISTRICTS.put("SANTANA", new LatLng(-8.0402249, -34.9150077));
		LAT_LNG_RECIFE_DISTRICTS.put("DOIS IRMAOS", new LatLng(-8.0078333, -34.9508919));
		LAT_LNG_RECIFE_DISTRICTS.put("VASCO DA GAMA", new LatLng(-8.0115898, -34.9188135));
		LAT_LNG_RECIFE_DISTRICTS.put("ALTO JOSE DO PINHO", new LatLng(-8.0222497, -34.9075245));
		LAT_LNG_RECIFE_DISTRICTS.put("CASA AMARELA", new LatLng(-8.0260294, -34.9168902));
		LAT_LNG_RECIFE_DISTRICTS.put("MANGABEIRA", new LatLng(-8.0238028, -34.9028477));
		LAT_LNG_RECIFE_DISTRICTS.put("ALTO JOSE BONIFACIO", new LatLng(-8.0131106, -34.913359));
		LAT_LNG_RECIFE_DISTRICTS.put("NOVA DESCOBERTA", new LatLng(-8.0074199, -34.9290427));
		LAT_LNG_RECIFE_DISTRICTS.put("GUABIRABA", new LatLng(-7.9660636, -34.9565234));
		LAT_LNG_RECIFE_DISTRICTS.put("PASSARINHO", new LatLng(-7.9782618, -34.9191998));
		LAT_LNG_RECIFE_DISTRICTS.put("MACAXEIRA", new LatLng(-8.0114768, -34.930457));
		LAT_LNG_RECIFE_DISTRICTS.put("CORREGO DO JENIPAPO", new LatLng(-8.0023856, -34.9362026));
		LAT_LNG_RECIFE_DISTRICTS.put("TAMARINEIRA", new LatLng(-8.0312357, -34.9018418));
		LAT_LNG_RECIFE_DISTRICTS.put("CÓRREGO DA AREIA", new LatLng(-8.0009885, -34.9298666));
		LAT_LNG_RECIFE_DISTRICTS.put("IPUTINGA", new LatLng(-8.0359139, -34.9356351));
		LAT_LNG_RECIFE_DISTRICTS.put("ILHA DO RETIRO", new LatLng(-8.062917, -34.902909));
		LAT_LNG_RECIFE_DISTRICTS.put("CORDEIRO", new LatLng(-8.0508949, -34.9285474));
		LAT_LNG_RECIFE_DISTRICTS.put("MADALENA", new LatLng(-8.0537866, -34.9085154));
		LAT_LNG_RECIFE_DISTRICTS.put("TORROES", new LatLng(-8.0607641, -34.9364392));
		LAT_LNG_RECIFE_DISTRICTS.put("ENGENHO DO MEIO", new LatLng(-8.0565744, -34.942367));
		LAT_LNG_RECIFE_DISTRICTS.put("VARZEA", new LatLng(-8.0463291, -34.9787962));
		LAT_LNG_RECIFE_DISTRICTS.put("BRASILIT", new LatLng(-8.0403885, -34.952288));
		LAT_LNG_RECIFE_DISTRICTS.put("CIDADE UNIVERSITÁRIA", new LatLng(-8.0538987, -34.9508455));
		LAT_LNG_RECIFE_DISTRICTS.put("CAXANGÁ", new LatLng(-8.0283802, -34.9543537));
		LAT_LNG_RECIFE_DISTRICTS.put("MANGUEIRA", new LatLng(-8.0764255, -34.9205324));
		LAT_LNG_RECIFE_DISTRICTS.put("SAN MARTIN", new LatLng(-8.0687152, -34.9302282));
		LAT_LNG_RECIFE_DISTRICTS.put("AFOGADOS", new LatLng(-8.0763554, -34.9128502));
		LAT_LNG_RECIFE_DISTRICTS.put("MUSTARDINHA", new LatLng(-8.0713994, -34.9192251));
		LAT_LNG_RECIFE_DISTRICTS.put("JIQUIA", new LatLng(-8.0851172, -34.9257802));
		LAT_LNG_RECIFE_DISTRICTS.put("AREIAS", new LatLng(-8.0947215, -34.9301097));
		LAT_LNG_RECIFE_DISTRICTS.put("ESTANCIA", new LatLng(-8.0851542, -34.9301794));
		LAT_LNG_RECIFE_DISTRICTS.put("COQUEIRAL", new LatLng(-8.0867931, -34.9691665));
		LAT_LNG_RECIFE_DISTRICTS.put("JARDIM SAO PAULO", new LatLng(-8.0822703, -34.944197));
		LAT_LNG_RECIFE_DISTRICTS.put("CURADO", new LatLng(-8.0712228, -34.9604539));
		LAT_LNG_RECIFE_DISTRICTS.put("BARRO", new LatLng(-8.0986103, -34.9496793));
		LAT_LNG_RECIFE_DISTRICTS.put("TEJIPIÓ", new LatLng(-8.090158, -34.9562088));
		LAT_LNG_RECIFE_DISTRICTS.put("TOTÓ", new LatLng(-8.0827529, -34.9684011));
		LAT_LNG_RECIFE_DISTRICTS.put("IMBIRIBEIRA", new LatLng(-8.1073868, -34.9121287));
		LAT_LNG_RECIFE_DISTRICTS.put("BOA VIAGEM", new LatLng(-8.1269379, -34.9007244));
		LAT_LNG_RECIFE_DISTRICTS.put("IPSEP", new LatLng(-8.1099473, -34.921826));
		LAT_LNG_RECIFE_DISTRICTS.put("PINA", new LatLng(-8.096611, -34.8941197));
		LAT_LNG_RECIFE_DISTRICTS.put("BRASILIA TEIMOSA", new LatLng(-8.0845955, -34.8796086));
		LAT_LNG_RECIFE_DISTRICTS.put("JORDÃO", new LatLng(-8.1364782, -34.9326882));
		LAT_LNG_RECIFE_DISTRICTS.put("IBURA", new LatLng(-8.1183458, -34.9323989));
		LAT_LNG_RECIFE_DISTRICTS.put("COHAB", new LatLng(-8.1240535, -34.9517691));
		LAT_LNG_RECIFE_DISTRICTS.put("DERBY", new LatLng(-8.0571821, -34.9002377));
	}
	
	public static String loadJSON(Context context, String path) {
        String json = null;
        try {
            InputStream is = context.getAssets().open(path);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (Exception ex) {
            return null;
        }
        return json;
    }
	
	public static void showDialog(Context context, String title, String message){
		QustomDialogBuilder dialog = new QustomDialogBuilder(context);
		dialog.setTitleColor(context.getResources().getColor(R.color.blue));
		dialog.setDividerColor(context.getResources().getColor(R.color.blue));
		dialog.setTitle(Html.fromHtml(title));
		dialog.setMessage(Html.fromHtml(message));
		dialog.setIcon(R.drawable.ic_launcher);
		dialog.show();
	}

}