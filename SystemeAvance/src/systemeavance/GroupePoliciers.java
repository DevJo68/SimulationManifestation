/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemeavance;

import java.util.ArrayList;

/**
 *le Groupe contient tous les policiers
 * @author e1603982
 */
public class GroupePoliciers extends Groupe {
   public GroupePoliciers(){
       super();
   }
   @Override
   public void Deplacement(){
        MembresGroupe.forEach((policier) -> {
           Deplacement();
       });
   }

}
