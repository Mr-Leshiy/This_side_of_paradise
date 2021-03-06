package com.mygdx.Lucky_Jumper.states;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.Lucky_Jumper.Backgrounds.MenuBackground;
import com.mygdx.Lucky_Jumper.ObjectControls.Button;
import com.mygdx.Lucky_Jumper.Resources.TexturesResources;
import com.mygdx.Lucky_Jumper.Resources.URL;
import com.mygdx.Lucky_Jumper.GameClass;

/**
 * Created by alexey on 05.01.17.
 */

public class SettingsState extends State {

    private MenuBackground background;
    private Button button_to_menu;
    private Button button_show_help;

    public SettingsState(final GameStateManager gsm, final MenuBackground background, final TexturesResources resources)
    {
        super(gsm,resources);
        this.background = background;
        Texture[] mas2 = {resources.button_to_main_menu,resources.button_to_main_menu_pressed};
        button_to_menu = new Button(mas2, GameClass.WIDTH/2-mas2[0].getWidth()/2,100);
        button_to_menu.setOnClickListener(new com.mygdx.Lucky_Jumper.ObjectControls.ButtonListener() {
            @Override
            public void onClickListener() {
                gsm.set(new MenuState(gsm,background,resources));

            }
        });

        Texture[] mas ={resources.button_show_help,resources.button_show_help_pressed};
        button_show_help= new Button(mas,GameClass.WIDTH/2-mas2[0].getWidth()/2,GameClass.HEIGTH/2);
        button_show_help.setOnClickListener(new com.mygdx.Lucky_Jumper.ObjectControls.ButtonListener() {
            @Override
            public void onClickListener() {

                gsm.set(new TrainingState(gsm,new SettingsState(gsm,background,resources),resources));

            }
        });

    }
    @Override
    protected void handleInput() {
        if(!Gdx.input.isTouched() && button_to_menu.isTouched)
        {
            button_to_menu.isTouched=false;
            button_to_menu.OnClick();
        }

        if(!Gdx.input.isTouched() && button_show_help.isTouched)
        {
            button_show_help.OnClick();
        }

        if(Gdx.input.justTouched())
        {

            if(button_to_menu.isClick(Gdx.input.getX()*GameClass.CONST_WIDTH,GameClass.HEIGTH-Gdx.input.getY()*GameClass.CONST_HEIGHT))
            {
                button_to_menu.isTouched=true;

            }
            if(button_show_help.isClick(Gdx.input.getX()*GameClass.CONST_WIDTH,GameClass.HEIGTH-Gdx.input.getY()*GameClass.CONST_HEIGHT))
            {
                button_show_help.isTouched=true;

            }
        }
    }

    @Override
    public void update(float delta) {

        handleInput();
        background.update(delta);

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        background.render(sb);
        button_to_menu.render(sb);
        button_show_help.render(sb);
        sb.end();

    }

    @Override
    public void dispose() {
        button_to_menu.dispose();
        button_show_help.dispose();

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

}
