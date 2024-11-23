package main.Shaders;

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

    public void passProjection(Projection proj){
        setUniformMatrix4f("projection",proj.projection);
        setUniformMatrix4f("model",proj.model);
        setUniformMatrix4f("view",proj.view);
    }
}
