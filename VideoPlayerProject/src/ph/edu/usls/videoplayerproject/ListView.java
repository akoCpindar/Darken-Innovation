package ph.edu.usls.videoplayerproject;

import java.io.File;
import java.io.FilenameFilter;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;

public class ListView extends ListActivity{
	ArrayAdapter<String> adapter;
	static String SD_PATH = new String("/sdcard/Video/");
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);	
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		adapter=new ArrayAdapter<String>(this, R.layout.video_item, getVideos());
		setListAdapter(adapter);
		
		android.widget.ListView listView=getListView();
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				// TODO Auto-generated method stub
				String absolutePath=parent.getItemAtPosition(position).toString();
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(), MainActivity.class);
				intent.putExtra("video", absolutePath);
				startActivity(intent);
				}
		});
				
	}	
	
	static String[] mFiles=null;
	
	public static String[] getVideos(){
		File videos = new File(SD_PATH);
		
		File[] videoslist=videos.listFiles(new FilenameFilter(){
			@Override
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				return ((name.endsWith(".mp4") || (name.endsWith(".MP4")
						|| (name.endsWith(".3gp") || (name.endsWith(".3GP"))))));
			}
		});
		mFiles=new String[videoslist.length];
		for(int i=0; i < videoslist.length; i++){
			mFiles[i]=videoslist[i].getAbsolutePath();
		}
		return mFiles;
	}
}
