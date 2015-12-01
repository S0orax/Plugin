package editor.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitActionListener implements ActionListener {

	/** actionPerformes(ActionEvent e)
	 * Exit the current frame
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}

}
