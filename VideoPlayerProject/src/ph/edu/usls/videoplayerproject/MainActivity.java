package ph.edu.usls.videoplayerproject;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends Activity{
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,  
			    WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);
		Bundle bundle=getIntent().getExtras();
		String path = bundle.getString("video");
		VideoView videoView =(VideoView)findViewById(R.id.videoview1);
		MediaController mc = new MediaController(this);
		mc.setAnchorView(videoView);
		Uri video=Uri.parse(path);
		videoView.setVideoURI(video);
		videoView.setMediaController(mc);
		videoView.start();		
	}
}