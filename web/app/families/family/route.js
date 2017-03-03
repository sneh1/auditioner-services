
import Ember from 'ember';

export default Ember.Route.extend({
  familyService: Ember.inject.service('family-service'),
  model(param){
    const familyService = this.get('familyService');
    return familyService.loadById(param.family_id);
  }
});
