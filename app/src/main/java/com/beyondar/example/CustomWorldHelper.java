/*
 * Copyright (C) 2014 BeyondAR
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.beyondar.example;

import android.annotation.SuppressLint;
import android.content.Context;
import com.beyondar.android.world.GeoObject;
import com.beyondar.android.world.World;

@SuppressLint("SdCardPath")
public class CustomWorldHelper {
	public static final int LIST_TYPE_EXAMPLE_1 = 5;

	public static World sharedWorld;

	public static World generateObjects(Context context) {
		if (sharedWorld != null) {
			return sharedWorld;
		}
		sharedWorld = new World(context);

		// The user can set the default bitmap. This is useful if you are
		// loading images form Internet and the connection get lost
		sharedWorld.setDefaultImage(R.drawable.beyondar_default_unknow_icon);

		// User position (you can change it using the GPS listeners form Android
		// API)
//		sharedWorld.setGeoPosition(41.90533734214473d, 2.565848038959814d);

		// Create an object with an image in the app resources.
		GeoObject go1 = new GeoObject(1l);
		go1.setGeoPosition(3.210150, 101.605527);
		go1.setImageResource(R.drawable.landmark_marker);
		go1.setName("Pos Laju Kepong");

		// Is it also possible to load the image asynchronously form internet
		GeoObject go2 = new GeoObject(1l);
		go2.setGeoPosition(3.211164, 101.605016);
		go2.setImageResource(R.drawable.landmark_marker);
		go2.setName("Havenice Com Sdn. Bhd");

		// Also possible to get images from the SDcard
		GeoObject go3 = new GeoObject(3l);
		go3.setGeoPosition(41.90550959641445d, 2.565873388087619d);
		go3.setImageResource(R.drawable.landmark_marker);
		go3.setName("IronMan from sdcard");

		GeoObject go4 = new GeoObject(4l);
		go4.setGeoPosition(3.210802, 101.604512);
		go4.setImageResource(R.drawable.landmark_marker);
		go4.setName("Gas World");

		
		// Add the GeoObjects to the world
		sharedWorld.addBeyondarObject(go1, LIST_TYPE_EXAMPLE_1);
		sharedWorld.addBeyondarObject(go2, LIST_TYPE_EXAMPLE_1);
		sharedWorld.addBeyondarObject(go3, LIST_TYPE_EXAMPLE_1);
		sharedWorld.addBeyondarObject(go4);

		return sharedWorld;
	}

}
