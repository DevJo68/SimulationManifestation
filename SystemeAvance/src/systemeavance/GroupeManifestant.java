/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemeavance;

import java.util.ArrayList;

/**
 *
 * @author e1603982
 */
public class GroupeManifestant extends Groupe {
   public GroupeManifestant(){
       super();
   }
   @Override
   public void Deplacement(){
       MembresGroupe.forEach((manifestant) -> {
           Deplacement();
       });
   }

}
