#version 450 core

in vec3 position;
in vec2 texCoord;

uniform mat4 projection;
uniform mat4 view;
uniform mat4 model;

out vec2 uv;

void main(void){
    gl_Position = projection * view * model * vec4(position,1.0);
    uv = texCoord;
}