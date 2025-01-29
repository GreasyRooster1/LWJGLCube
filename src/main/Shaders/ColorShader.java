package main.Shaders;

public class ColorShader extends Shader {
    public ColorShader() {
        super("resources/shaders/color.vert", "resources/shaders/color.frag");
    }

    @Override
    protected void bindAttributes() {
        bindAttribute(0, "position");
    }

}
