package com.example.r00143659.Juegos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

public class AlertDialogFragment extends DialogFragment {
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		final ChaChaCha main = (ChaChaCha) getActivity();

		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				getActivity());
		alertDialogBuilder.setTitle(R.string.gameOverTitle); //Titulo de la cabecera
		alertDialogBuilder.setMessage(R.string.gameOverMessage);//Mensaje debajo del titulo
		alertDialogBuilder.setPositiveButton("Yes",  //Escuchador que debe ser ejecutado al pulsar YES
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						main.gameChaChaCha.restart();//reiniciar grid
						main.setFigureFromGrid();//redibujar tablero
						dialog.dismiss();// Se elimina el dialogo
					}
				});
		alertDialogBuilder.setNegativeButton("No", //Cuando se puLsa no
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						main.finish();//Termina la actividad y vuelve a la principal
						dialog.dismiss();//Borra el dialogo
					}
				});
		return alertDialogBuilder.create();
	}
}