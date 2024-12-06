package main.Mesh;

import main.Camera;
import main.Shaders.ProjectionShaderProgram;
import main.Texture.Texture;
import org.joml.Matrix4f;

import static main.Mesh.MeshLoader.createMesh;
import static org.lwjgl.opengl.GL30.*;

public class MeshObject {
    public Mesh mesh;
    public ProjectionShaderProgram shader;
    public Texture texture;

    public MeshObject(Mesh mesh, ProjectionShaderProgram shader) {
        this.mesh = mesh;
        this.shader = shader;
    }

    public void render(Camera camera){
        shader.passCamera(camera);
        shader.passModel(new Matrix4f());
        shader.use();
        glBindVertexArray(mesh.getVaoID());
        glEnableVertexAttribArray(0);
        glEnableVertexAttribArray(1);
        if(texture!=null) {
            glActiveTexture(GL_TEXTURE0);
            glBindTexture(GL_TEXTURE_2D, texture.textureID);
        }
        glDrawElements(GL_LINE_STRIP, mesh.getVertexCount(), GL_UNSIGNED_INT,0);
        glDisableVertexAttribArray(0);
        glDisableVertexAttribArray(1);
        glBindVertexArray(0);
    }
}
