package main.Objects;

import main.Mesh.Mesh;
import main.Shaders.ProjectionShaderProgram;
import main.Shaders.SkyBoxShader;
import main.Texture.CubeMap;

public class SkyBox extends MeshObject{
    public SkyBox(Mesh mesh, CubeMap cubeMap) {
        super(mesh, new SkyBoxShader());
    }
}
