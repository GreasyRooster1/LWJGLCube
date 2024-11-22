package main.Shaders;

public class TextureShader extends ShaderProgram {
    public TextureShader() {
        super("resources/shaders/texture.vert", "resources/shaders/texture.frag");
    }

    @Override
    protected void bindAttributes() {
        bindAttribute(0, "position");
        bindAttribute(1,"texCoords");
    }

}
