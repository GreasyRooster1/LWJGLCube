package main;

import org.joml.Matrix4f;
import org.joml.Vector2f;
import org.joml.Vector3f;

import static main.Main.HEIGHT;
import static main.Main.WIDTH;

public class Camera {
    private Vector3f position;
    private Vector3f direction;

    private Matrix4f projection;
    private Matrix4f view;

    private float fov;
    private float nearClip;
    private float farClip;

    Camera(Vector3f position,Vector3f target) {
        fov = 45f;
        nearClip = .1f;
        farClip = 100f;

        this.position = position;
        direction = position.sub(target).normalize();

        recalculate();
    }

    public void recalculate() {
        projection = new Matrix4f().perspective((float) Math.toRadians(fov), (float)WIDTH/(float)HEIGHT, nearClip, farClip);
        view = new Matrix4f().translate(position);
    }

    public void lookAt(Vector3f target){
        direction = position.sub(target).normalize();
        recalculate();
    }

    public Matrix4f getView() {
        return view;
    }
    public Matrix4f getProjection() {
        return projection;
    }

    public Vector3f getPosition() {
        return position;
    }

    public void setPosition(Vector3f position) {
        this.position = position;
        recalculate();
    }

    public Vector3f getDirection() {
        return position;
    }

    public void setDirection(Vector3f direction) {
        this.direction = direction;
        recalculate();
    }

    public void setNearClip(float nearClip) {
        this.nearClip = nearClip;
        recalculate();
    }
    public float getNearClip() {
        return nearClip;
    }

    public void setFarClip(float farClip) {
        this.farClip = farClip;
        recalculate();
    }
    public float getFarClip() {
        return farClip;
    }

    public void setFov(float fov) {
        this.fov = fov;
        recalculate();
    }
    public float getFov() {
        return fov;
    }
}
