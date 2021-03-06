package helpers;

import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;

import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex2f;
import static org.lwjgl.opengl.GL11.glBlendFunc;

import java.io.IOException;
import java.io.InputStream;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;
public class Artist {
	
	public static final int WIDTH = 1280, HEIGHT = 960;
	
	/**
	* Starts our game with some necessary settings
	*/
	public static void BeginSession(){
		Display.setTitle("CCG Game");
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}

		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, WIDTH, HEIGHT, 0, 1, -1);//Setting up our camera
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_TEXTURE_2D);
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
	}
	
	/**
	 * Draws a quadrant onto the screen
	 * @param x The starting x
	 * @param y The starting y
	 * @param width is the width of the quad
	 * @param height is the height of the quad
	 */
	public static void DrawQuad(float x, float y, float width, float height){
		glBegin(GL_QUADS);
		glVertex2f(x, y);//Top left corner
		glVertex2f(x + width, y);//Top right corner
		glVertex2f(x+ width ,y + height);//Bottom right corner
		glVertex2f(x, y + height);//Bottom left corner
		glEnd();
	}
	
	/**
	 * Draws the texture in our quadrant
	 * @param tex
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public static void DrawQuadTex(Texture tex, float x, float y, float width, float height) {
		tex.bind();
		glTranslatef(x, y, 0);//Decide the "new" 0,0
		glBegin(GL_QUADS);
		glTexCoord2f(0,0);
		glVertex2f(0, 0);
		glTexCoord2f(1,0);
		glVertex2f(width, 0);
		glTexCoord2f(1,1);
		glVertex2f(width, height);
		glTexCoord2f(0,1);
		glVertex2f(0, height);		
		glEnd();
		glLoadIdentity();//Screen Tearing
	}
	
	/**
	 * Inputs a texture file
	 * @param path the path to the texture
	 * @param fileType the file type of the file
	 * @return the texture file
	 */
	public static Texture LoadTexture(String path, String fileType){
		Texture tex = null;
		InputStream in = ResourceLoader.getResourceAsStream(path);//Allows us to take in outside resources into our program
		try {
			tex = TextureLoader.getTexture(fileType, in);
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return tex;
	}

	/**
	 * A shortened function to quickly get an obvious png texture file from LoadTexture() 
	 * @param name the name of the file
	 * @return the texture file
	 */
	public static Texture QuickLoad(String name){
		Texture tex = null;
		tex = LoadTexture("res/" + name + ".png", "PNG");		
		
		return tex;
	}
	
}
