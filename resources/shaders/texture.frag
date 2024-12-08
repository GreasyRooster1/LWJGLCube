#version 450 core

in vec2 uv;

out vec4 out_Color;

uniform sampler2D textureSampler;

void main(){
    out_Color = texture(textureSampler,vec2(uv.x,1.-uv.y));
}