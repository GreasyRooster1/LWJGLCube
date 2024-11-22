package main.Texture;

import org.lwjgl.stb.STBImage;
import org.lwjgl.system.MemoryStack;

import java.io.File;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import static org.lwjgl.opengl.GL33.*;

public class Texture {
    public final int textureID;

    public Texture(String texturePath) {
        int width;
        int height;
        int id = 0;
        ByteBuffer buffer;
        try (MemoryStack stack = MemoryStack.stackPush()){
            IntBuffer w = stack.mallocInt(1);
            IntBuffer h = stack.mallocInt(1);
            IntBuffer channels = stack.mallocInt(1);

            URL url = Texture.class.getResource(texturePath);
            File file = new File(texturePath);
            String filePath = file.getAbsolutePath();
            buffer = STBImage.stbi_load(filePath, w, h, channels, 4);
            if(buffer ==null) {
                throw new Exception("Can't load file "+texturePath+" "+STBImage.stbi_failure_reason());
            }
            width = w.get();
            height = h.get();

            id = glGenTextures();
            glBindTexture(GL_TEXTURE_2D, id);
            glPixelStorei(GL_UNPACK_ALIGNMENT, 1);

            glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width, height, 0, GL_RGBA, GL_UNSIGNED_BYTE, buffer);

            glGenerateMipmap(GL_TEXTURE_2D);
            STBImage.stbi_image_free(buffer);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        textureID = id;
    }
}
