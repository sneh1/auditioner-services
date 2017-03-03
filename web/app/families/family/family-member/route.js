
import Ember from 'ember';

export default Ember.Route.extend({
  familyMemberService: Ember.inject.service('family-member-service'),
  model(param){
    const familyMemberService = this.get('familyMemberService');
    return {
      family: familyService.loadById(param.family_id),
      familyMembers:Ember.A([
        Ember.Object.create({
          "firstName":"Tammy",
          "lastName":"Smith Jr",
          "age":14
        }),
        Ember.Object.create({
          "firstName":"Lisa",
          "lastName":"Smith",
          "age":12
        })
      ])
    };
  }
});
