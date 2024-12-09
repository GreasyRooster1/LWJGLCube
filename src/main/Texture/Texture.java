package main.Texture;

import org.lwjgl.stb.STBImage;
import org.lwjgl.system.MemoryStack;

import java.io.File;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import static org.lwjgl.opengl.GL11.glBindTexture;
import static org.lwjgl.opengl.GL33.*;

public class Texture {
    public  int textureID;

    public Texture(String texturePath) {
        load(texturePath);
    }

    public Texture() {
    }

    public void load(String texturePath){
        textureID = TextureLoader.loadTexture(texturePath);
    }
    public void setTextureID(int textureID) {
        this.textureID = textureID;
    }
}
