package main.Texture;

import org.lwjgl.stb.STBImage;
import org.lwjgl.system.MemoryStack;

import java.io.File;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL30.glGenerateMipmap;

public class TextureLoader {
    private static ByteBuffer loadData(String path,IntBuffer width,IntBuffer height){
        ByteBuffer buffer = null;
        try (MemoryStack stack = MemoryStack.stackPush()) {
            IntBuffer w = stack.mallocInt(1);
            IntBuffer h = stack.mallocInt(1);
            IntBuffer channels = stack.mallocInt(1);

            File file = new File(path);
            String filePath = file.getAbsolutePath();
            STBImage.stbi_set_flip_vertically_on_load(true);
            buffer = STBImage.stbi_load(filePath, w, h, channels, 4);
            if (buffer == null) {
                throw new Exception("Can't load file " + path + " " + STBImage.stbi_failure_reason());
            }
            width.put(w.get());
            height.put(h.get());
        }catch(Exception e){
            e.printStackTrace();
        }
        return buffer;
    }

    public static int loadTexture(String path){
        IntBuffer w = IntBuffer.allocate(1);
        IntBuffer h = IntBuffer.allocate(1);
        ByteBuffer buffer = loadData(path,w,h);

        int id = glGenTextures();
        glBindTexture(GL_TEXTURE_2D, id);
        glPixelStorei(GL_UNPACK_ALIGNMENT, 1);

        glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, w.get(), h.get(), 0, GL_RGBA, GL_UNSIGNED_BYTE, buffer);

        glGenerateMipmap(GL_TEXTURE_2D);
        STBImage.stbi_image_free(buffer);
        glBindTexture(GL_TEXTURE_2D,0);

        return id;
    }

    public static int loadCubeMap(String path){
        IntBuffer w = IntBuffer.allocate(1);
        IntBuffer h = IntBuffer.allocate(1);
        ByteBuffer buffer = loadData(path,w,h);

        int id = glGenTextures();
        glBindTexture(GL_TEXTURE_2D, id);
        glPixelStorei(GL_UNPACK_ALIGNMENT, 1);

        glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, w.get(), h.get(), 0, GL_RGBA, GL_UNSIGNED_BYTE, buffer);

        glGenerateMipmap(GL_TEXTURE_2D);
        STBImage.stbi_image_free(buffer);
        glBindTexture(GL_TEXTURE_2D,0);

        return id;
    }
}
