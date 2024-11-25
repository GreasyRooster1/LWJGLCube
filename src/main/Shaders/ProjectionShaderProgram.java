package main.Shaders;

import main.Camera;
import main.Files;
import main.Projection;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.BufferUtils;

import java.nio.FloatBuffer;

import static org.lwjgl.opengl.GL33.*;

public abstract class ProjectionShaderProgram extends ShaderProgram {

    public ProjectionShaderProgram(String vertPath, String fragPath) {
        super(vertPath, fragPath);
    }
    public ProjectionShaderProgram(String fragPath) {
        super("resources/shaders/universal.vert", fragPath);
    }

    public void defaultBinds(){
        bindAttribute(0, "position");
        bindAttribute(1,"texCoords");
    }

    public void passCamera(Camera camera){
        setUniformMatrix4f("projection",camera.getProjection());
        setUniformMatrix4f("view",camera.getView());
    }

    public void passModel(Matrix4f model){
        setUniformMatrix4f("model",model);
    }
}
