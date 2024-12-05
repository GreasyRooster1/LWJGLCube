package main.Mesh;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.BufferUtils;
import static org.lwjgl.opengl.GL33.*;


public class MeshLoader {

    private static List<Integer> vaos = new ArrayList<Integer>();
    private static List<Integer> vbos = new ArrayList<Integer>();

    public static Mesh createMesh(float[] positions, float[] UVs, int[] indices) {
        int vao = genVAO();
        storeData(0,3,positions);
        storeData(1,2,UVs);
        bindIndices(indices);
        glBindVertexArray(0);
        return new Mesh(vao,createIntBuffer(indices),indices.length);
    }

    private static int genVAO() {
        int vao = glGenVertexArrays();
        vaos.add(vao);
        glBindVertexArray(vao);
        return vao;
    }

    private static FloatBuffer createFloatBuffer(float[] data) {
        FloatBuffer buffer = BufferUtils.createFloatBuffer(data.length);
        buffer.put(data);
        buffer.flip();
        return buffer;
    }

    private static IntBuffer createIntBuffer(int[] data) {
        IntBuffer buffer = BufferUtils.createIntBuffer(data.length);
        buffer.put(data);
        buffer.flip();
        return buffer;
    }

    private static void storeData(int attribute, int dimensions, float[] data) {
        int vbo = glGenBuffers(); //Creates a VBO ID
        vbos.add(vbo);
        glBindBuffer(GL_ARRAY_BUFFER, vbo); //Loads the current VBO to store the data
        FloatBuffer buffer = createFloatBuffer(data);
        glBufferData(GL_ARRAY_BUFFER, buffer, GL_STATIC_DRAW);
        glVertexAttribPointer(attribute, dimensions, GL_FLOAT, false, 0, 0);
        glBindBuffer(GL_ARRAY_BUFFER, 0); //Unloads the current VBO when done.
    }

    private static void bindIndices(int[] data) {
        int vbo = glGenBuffers();
        vbos.add(vbo);
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, vbo);
        IntBuffer buffer = createIntBuffer(data);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, buffer, GL_STATIC_DRAW);
    }
}
